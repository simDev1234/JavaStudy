// Practice
// 아래 Device 추상 클래스를 이용하여
// UsbPort1 클래스와 WiFi 클래스를 자유롭게 구현해보세요.

abstract class Device {
    int deviceId;

    abstract void deviceInfo();
    abstract void connect();
    abstract void disconnect();
    abstract void send();
    abstract void receive();
}

// UsbPort1 클래스
class UsbPort1 extends Device {

    public UsbPort1() {
    }

    public UsbPort1(int deviceId) {
        this.deviceId = deviceId;
    }

    @Override
    void deviceInfo() {
        System.out.println("deviceInfo : UsbPort1");
    }

    @Override
    void connect() {
        System.out.println("USB connected");
    }

    @Override
    void disconnect() {
        System.out.println("USB disconnected");
    }

    @Override
    void send() {
        System.out.println("send thru USB");
    }

    @Override
    void receive() {
        System.out.println("receive thru USB");
    }
}

// WiFi 클래스
class WiFi extends Device {
    public WiFi() {
    }

    public WiFi(int devideId) {
        this.deviceId = deviceId;
    }

    @Override
    void deviceInfo() {
        System.out.println("deviceInfo : WiFi");
    }

    @Override
    void connect() {
        System.out.println("WiFi connected");
    }

    @Override
    void disconnect() {
        System.out.println("WiFi disconnected");
    }

    @Override
    void send() {
        System.out.println("send thru WiFi");
    }

    @Override
    void receive() {
        System.out.println("receive thru WiFi");
    }
}


public class Practice {

    public static void main(String[] args) {
        // Test code
        UsbPort1 usb1 = new UsbPort1(1);
        WiFi wifi = new WiFi(0);

        System.out.println(usb1.deviceId);
    }

}