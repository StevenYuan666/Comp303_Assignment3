import java.io.File;

public class Driver {
	public static void main(String[] args) {
		//Create a Library
		Library l1 = Library.getLibrary();
		System.out.println("Default Name: " + l1.getName());
		System.out.println("Default Email: " + l1.getEmailID());
		l1.setName("Steven's Library");
		System.out.println("New Name: " + l1.getName());
		l1.setEmailID("ye.yuan3@mail.mcgill.ca");
		System.out.println("New Email: " + l1.getEmailID());
		//Try to use an invalid email address
		try {
			l1.setEmailID("@qq.com");
			System.out.println("Test failed");
		}
		catch(AssertionError e){
			System.out.println("Cannot use an invalid Email Address");
		}
		//Test if the singleton is implemented
		Library l2 = Library.getLibrary();
		System.out.println("Check if the singleton is implemented: " + (l1 == l2));
		
		//Movies and TVShow
		File f1 = new File("./Transformer1.mp4");
		Movie m1 = Movie.getMovie(f1, "Transformer1", Language.ENGLISH, "Studio1");
		File f11= new File("./AnotherTransformer1.mp4");
		Movie m2 = Movie.getMovie(f11, "Transformer1", Language.FRENCH, "Studio11");
		System.out.println("Check if the flyweight is implemented in Movie: " + (m1 == m2));
		
		TVShow t1 = TVShow.getTVShow("Singer", Language.ANCIENT_GREEK, "Studio2");
		TVShow t2 = TVShow.getTVShow("Singer", Language.LATIN, "Studio22");
		System.out.println("Check if the flyweight is implemented in TVShow: " + (t1 == t2));
		
		//Check equals method
		File a1 = new File("../Avengers.mp4");
		Movie avenger = Movie.getMovie(a1, "Avengers", Language.ENGLISH, "Marvel");
		File a2 = new File("../Avengers2.mp4");
		Movie avenger2 = Movie.getMovie(a2, "Avengers2", Language.ENGLISH, "Marvel");
		File a3 = new File("../Avengers3.mp4");
		Movie avenger3 = Movie.getMovie(a3, "Avengers3", Language.ENGLISH, "Marvel");
		TVShow singer = TVShow.getTVShow("Singer", Language.ENGLISH, "Hunan");
		File ep1 = new File("../Singer-EP1.mp4");
		singer.createAndAddEpisode(ep1, "Singer EP1");
		File ep2 = new File("../Singer-EP2.mp4");
		singer.createAndAddEpisode(ep2, "Singer EP2");
		File ep3 = new File("../Singer-EP3.mp4");
		singer.createAndAddEpisode(ep3, "Singer EP3");
		
		WatchList w1 = new WatchList("WatchList1");
		WatchList w2 = new WatchList("WatchList2");
		WatchList w3 = new WatchList("WatchList3");
		WatchList w4 = new WatchList("WatchList4");
		
		//Add same objects to w1 and w2
		w1.addWatchable(avenger);
		w1.addWatchable(avenger2);
		w1.addWatchable(avenger3);
		w1.addWatchable(singer);
		w2.addWatchable(avenger);
		w2.addWatchable(avenger2);
		w2.addWatchable(avenger3);
		w2.addWatchable(singer);
		System.out.println("Check whether the same watch lists are considered as same: " + 
		w1.equals(w2));
		//Try same content with different order
		w3.addWatchable(singer);
		w3.addWatchable(avenger3);
		w3.addWatchable(avenger);
		w3.addWatchable(avenger2);
		System.out.println("Check whether the same content but different order are considered "
				+ "as same: " + w2.equals(w3));
		//Try Different content
		w4.addWatchable(avenger3);
		w4.addWatchable(singer);
		System.out.println("Check whether differemt watch lists are considered as same: " + 
				w1.equals(w4));
	}
}
