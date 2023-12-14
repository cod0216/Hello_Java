package access;

public class Speaker {
    int volume;
    Speaker(int volume) {
        this.volume = volume;
    }

    void volumeup(){
        if(volume >= 100) {
            System.out.println("음량을 증가할 수 없습니다. 최대 음량입니다.");
        } else {
            volume += 10;
            System.out.println("음량을 10 증가합니다.");
        }
    }
    void volumedown(){
        if(volume <= 0) {
            System.out.println("음량을 감소할 수 없습니다. 최소 음량입니다.");
        } else {
            volume -= 10;
            System.out.println("음량을 10 감소합니다.");
        }
    }
    void showvolume() {
        System.out.println("현재 음량은 " + volume + "입니다.");
    }
}
