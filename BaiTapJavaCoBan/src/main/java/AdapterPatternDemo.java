// Interface cu
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Interface moi (VLC)
interface AdvancedMediaPlayer {
    void playVlc(String fileName);
}

class VlcPlayer implements AdvancedMediaPlayer {
    public void playVlc(String fileName) {
        System.out.println("Dang phat file VLC: " + fileName);
    }
}

// Lop Adapter - Cau noi giua cu va moi
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer vlcPlayer = new VlcPlayer();

    public void play(String audioType, String fileName) {
        if(audioType.equalsIgnoreCase("vlc")) {
            vlcPlayer.playVlc(fileName);
        }
    }
}

public class AdapterPatternDemo {
    public static void main(String[] args) {
        MediaAdapter adapter = new MediaAdapter();
        adapter.play("vlc", "bai_hat_moi.vlc");
    }
}
