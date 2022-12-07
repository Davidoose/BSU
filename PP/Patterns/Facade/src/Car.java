public class Car {
    public Battery battery;
    public Starter starter;
    public Engine engine;
    public void start(){
        battery.getEnergy();
        starter.on();
        engine.start(starter);
        starter.off(engine);
    }
}
