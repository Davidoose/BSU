public class Starter {
    public String state = "off";
    public void on(){
        state = "on";
        System.out.println("Starter will turn on for a short time to start the engine");
    }
    public void off(Engine engine){
        if(engine.state == "on") {
            state = "off";
            System.out.println("Starter will turn off because engine on");
        }
    }
}
