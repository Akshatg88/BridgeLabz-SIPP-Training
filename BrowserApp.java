import java.util.Scanner;

// Node class for browser history
class PageNode {
    String url;
    PageNode prev, next;

    public PageNode(String url) {
        this.url = url;
    }
}

// Abstract navigation class
abstract class Navigator {
    protected PageNode current;
    public abstract void visit(String url);
    public abstract boolean back();
    public abstract boolean forward();
    public abstract String getCurrentPage();
}

// Browser history using doubly linked list
class BrowserHistory extends Navigator {

    public BrowserHistory(String homepage) {
        current = new PageNode(homepage);
    }

    @Override
    public void visit(String url) {
        PageNode newPage = new PageNode(url);
        current.next = null;  // Clear forward history
        newPage.prev = current;
        current.next = newPage;
        current = newPage;
        System.out.println("Visited: " + url);
    }

    @Override
    public boolean back() {
        if (current.prev != null) {
            current = current.prev;
            System.out.println("Went back to: " + current.url);
            return true;
        }
        System.out.println("No previous page.");
        return false;
    }

    @Override
    public boolean forward() {
        if (current.next != null) {
            current = current.next;
            System.out.println("Went forward to: " + current.url);
            return true;
        }
        System.out.println("No forward page.");
        return false;
    }

    @Override
    public String getCurrentPage() {
        return current.url;
    }
}

// Interactive Main Class for Browser
public class BrowserApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BrowserHistory browser = new BrowserHistory("home.com");

        while (true) {
            System.out.println("\n--- Browser History Menu ---");
            System.out.println("1. Visit new URL");
            System.out.println("2. Back");
            System.out.println("3. Forward");
            System.out.println("4. Current Page");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter URL: ");
                    String url = scanner.nextLine();
                    browser.visit(url);
                    break;
                case 2:
                    browser.back();
                    break;
                case 3:
                    browser.forward();
                    break;
                case 4:
                    System.out.println("Current Page: " + browser.getCurrentPage());
                    break;
                case 5:
                    System.out.println("Exiting Browser History...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        }
    }
}
