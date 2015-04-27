package assetsPc.audio;

/**
 * Interfaccia per componenti dedicati all'esecuzione dei suoni.
 * @author Bianca
 */
public interface IAudioPlayer {
	
	/**
	 * Avvia il suono.
	 */
	public void play();
	
	/**
	 * Interrompe il suono.
	 */
	public void stop();
}
