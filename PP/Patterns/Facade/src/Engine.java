public class Engine {
    public String state = "off";
    public void start(Starter starter){
        if(starter.state == "on"){
            state = "on";
            System.out.println("Engine starts");
        }
    }
}
