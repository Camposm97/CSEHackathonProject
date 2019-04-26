package workbench;

public class ThreadDemo {
	public static void main(String[] args) {
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.print("A" + " ");
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.print("1" + " ");
			}
		}).start();
		new Thread(() -> {
			for (int i = 0; i < 100; i++) {
				System.out.print("," + " ");
			}
		}).start();
	}
}
