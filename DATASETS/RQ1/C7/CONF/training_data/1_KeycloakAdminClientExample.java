



public class KeycloakAdminClientExample {

    public static void main(String[] args) {

        String serverUrl = "http:
        String realm = "acme";
        
        String clientId = "idm-client";
        String clientSecret = "0d61686d-57fc-4048-b052-4ce74978c468";









        
        Keycloak keycloak = KeycloakBuilder.builder() 
                .serverUrl(serverUrl) 
                .realm(realm) 
                .grantType(OAuth2Constants.PASSWORD) 
                .clientId(clientId) 
                .clientSecret(clientSecret) 
                .username("idm-admin") 
                .password("admin") 
                .build();

         Define user
        UserRepresentation user = new UserRepresentation();
        user.setEnabled(true);
        user.setUsername("tester1");
        user.setFirstName("First");
        user.setLastName("Last");
        user.setEmail("tom+tester1@tdlabs.local");
        user.setAttributes(Collections.singletonMap("origin", Arrays.asList("demo")));

         Get realm
        RealmResource realmResource = keycloak.realm(realm);
        UsersResource usersRessource = realmResource.users();

         Create user (requires manage-users role)
        Response response = usersRessource.create(user);
        System.out.printf("Repsonse: %s %s%n", response.getStatus(), response.getStatusInfo());
        System.out.println(response.getLocation());
        String userId = CreatedResponseUtil.getCreatedId(response);

        System.out.printf("User created with userId: %s%n", userId);

         Define password credential
        CredentialRepresentation passwordCred = new CredentialRepresentation();
        passwordCred.setTemporary(false);
        passwordCred.setType(CredentialRepresentation.PASSWORD);
        passwordCred.setValue("test");

        UserResource userResource = usersRessource.get(userId);

         Set password credential
        userResource.resetPassword(passwordCred);

         Get realm role "tester" (requires view-realm role)
        RoleRepresentation testerRealmRole = realmResource.roles()
                .get("tester").toRepresentation();

         Assign realm role tester to user
        userResource.roles().realmLevel() 
                .add(Arrays.asList(testerRealmRole));

         Get client
        ClientRepresentation app1Client = realmResource.clients() 
                .findByClientId("app-frontend-springboot").get(0);

         Get client level role (requires view-clients role)
        RoleRepresentation userClientRole = realmResource.clients().get(app1Client.getId()) 
                .roles().get("user").toRepresentation();

         Assign client level role to user
        userResource.roles() 
                .clientLevel(app1Client.getId()).add(Arrays.asList(userClientRole));

         Send password reset E-Mail
         VERIFY_EMAIL, UPDATE_PROFILE, CONFIGURE_TOTP, UPDATE_PASSWORD, TERMS_AND_CONDITIONS
        usersRessource.get(userId).executeActionsEmail(Arrays.asList("UPDATE_PASSWORD"));

         Delete User
        userResource.remove();
    }
}
