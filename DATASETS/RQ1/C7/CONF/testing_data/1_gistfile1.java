                
		
		User_auth auth = new User_auth();
		auth.setUser_name(USER_NAME);
		auth.setPassword(PASSWORD);
		
		
		Name_value nameValueListLogin[] = null;
		
		
		Entry_value loginResponse = null;
		try {
			loginResponse = stub.login(auth, APPLICATION_NAME , nameValueListLogin);
		} catch (RemoteException e) {
			System.out.println("login failed. Message: "+e.getMessage());
			e.printStackTrace();
		}
		System.out.println("login successful! login id: "+loginResponse.getId());
