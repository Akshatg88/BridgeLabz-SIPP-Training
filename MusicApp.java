import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// Abstract media player
abstract class MediaPlayer {
    protected Queue<String> playlist = new LinkedList<>();
    public abstract void addSong(String song);
    public abstract String playNext();
    public abstract boolean removeSong(String song);
    public abstract void showPlaylist();
}

// Music player using queue
class MusicPlayer extends MediaPlayer {

    @Override
    public void addSong(String song) {
        playlist.offer(song);
        System.out.println("Added to playlist: " + song);
    }

    @Override
    public String playNext() {
        String song = playlist.poll();
        if (song != null) {
            System.out.println("Now playing: " + song);
        } else {
            System.out.println("Playlist is empty.");
        }
        return song;
    }

    @Override
    public boolean removeSong(String song) {
        boolean removed = playlist.remove(song);
        System.out.println(removed ? "Removed: " + song : "Song not found.");
        return removed;
    }

    @Override
    public void showPlaylist() {
        if (playlist.isEmpty()) {
            System.out.println("Playlist is empty.");
        } else {
            System.out.println("Current Playlist: " + playlist);
        }
    }
}

// Interactive Main Class for Music Player
public class MusicApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MusicPlayer player = new MusicPlayer();

        while (true) {
            System.out.println("\n--- Music Playlist Menu ---");
            System.out.println("1. Add Song");
            System.out.println("2. Play Next Song");
            System.out.println("3. Remove Song");
            System.out.println("4. Show Playlist");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter song name: ");
                    String song = scanner.nextLine();
                    player.addSong(song);
                    break;
                case 2:
                    player.playNext();
                    break;
                case 3:
                    System.out.print("Enter song to remove: ");
                    String toRemove = scanner.nextLine();
                    player.removeSong(toRemove);
                    break;
                case 4:
                    player.showPlaylist();
                    break;
                case 5:
                    System.out.println("Exiting Music Player...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
