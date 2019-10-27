public class test {

    public static void main(String[] args) {
        System.out.println("11111111111111111111");
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                    System.out.println("33333333");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }.start();

        System.out.println("222222222");


    }

}
