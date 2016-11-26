public class Autosave implements Runnable {
    private Register register;
    private FileManager fileManager = new FileManager();

    public Autosave(Register register){
        this.register = register;
    }
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            fileManager.writeFile(register);
        }
    }
}
