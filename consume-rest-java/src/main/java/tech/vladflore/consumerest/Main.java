package tech.vladflore.consumerest;

public class Main {
	public static void main(String[] args) {
		if (args.length != 1) {
			throw new IllegalArgumentException("One argument needed, specifically the url to call");
		}

		WebService webService = new WebServiceImpl(args[0]);

		UseCase useCase = new UseCase();
		useCase.setWebService(webService);
		System.out.println(useCase.listUsernamesAlphabetically());
	}
}
