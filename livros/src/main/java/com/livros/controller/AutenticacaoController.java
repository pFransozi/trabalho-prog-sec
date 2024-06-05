package controller;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProvider;
import com.amazonaws.services.cognitoidp.AWSCognitoIdentityProviderClientBuilder;
import com.amazonaws.services.cognitoidp.model.AdminInitiateAuthRequest;
import com.amazonaws.services.cognitoidp.model.AdminInitiateAuthResult;
import com.amazonaws.services.cognitoidp.model.AuthFlowType;

import java.util.HashMap;
import java.util.Map;

public class AutenticacaoController {
    private final String clientId;
    private final String userPoolId;
    private final AWSCognitoIdentityProvider cognitoClient;

    public AutenticacaoController() {
        this.clientId = System.getenv("COGNITO_CLIENT_ID");
        this.userPoolId = System.getenv("COGNITO_USER_POOL_ID");
        String awsAccessKey = System.getenv("AWS_ACCESS_KEY_ID");
        String awsSecretKey = System.getenv("AWS_SECRET_ACCESS_KEY");
        String awsRegion = System.getenv("AWS_REGION");

        if (clientId == null || userPoolId == null || awsAccessKey == null || awsSecretKey == null || awsRegion == null) {
            throw new RuntimeException("Configurações do AWS Cognito não encontradas nas variáveis de ambiente.");
        }

        BasicAWSCredentials awsCreds = new BasicAWSCredentials(awsAccessKey, awsSecretKey);
        this.cognitoClient = AWSCognitoIdentityProviderClientBuilder.standard()
                .withCredentials(new AWSStaticCredentialsProvider(awsCreds))
                .withRegion(Regions.fromName(awsRegion))
                .build();
    }

    public String autenticar(String username, String password) {
        final Map<String, String> authParams = new HashMap<>();
        authParams.put("USERNAME", username);
        authParams.put("PASSWORD", password);

        final AdminInitiateAuthRequest authRequest = new AdminInitiateAuthRequest()
                .withAuthFlow(AuthFlowType.ADMIN_NO_SRP_AUTH)
                .withClientId(clientId)
                .withUserPoolId(userPoolId)
                .withAuthParameters(authParams);

        try {
            AdminInitiateAuthResult result = cognitoClient.adminInitiateAuth(authRequest);
            return result.getAuthenticationResult().getAccessToken();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
