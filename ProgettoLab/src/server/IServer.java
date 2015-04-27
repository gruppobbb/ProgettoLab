package server;

public interface IServer {
	
	public void launch();

	public void addService(String name, IService service);

}
