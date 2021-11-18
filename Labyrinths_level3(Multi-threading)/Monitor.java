import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


class Monitor {
	private final Lock lock = new ReentrantLock();
	private Lenkeliste<Lenkeliste<Route>> possiblePathList = new Lenkeliste<>();

	public void addPathToList(Lenkeliste<Route> r) {
		lock.lock();
		try{
			possiblePathList.leggTil(r);
				
		} finally{
			lock.unlock();
		}

	}

	public Lenkeliste<Lenkeliste<Route>> hentListe(){
		return possiblePathList;
	}
}


