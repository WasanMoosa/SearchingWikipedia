package org.search.wikipedia;

/**
 * A class representing information about a page retrieved from the Wikipedia API.
 */
public class PageInfo {
    private String title;
    private String snippet;
    private String url;

    /**
     * Constructs a new PageInfo object with the given title, snippet, and URL.
     * @param title The title of the page.
     * @param snippet A snippet of text describing the page.
     * @param url The URL of the page.
     */
    public PageInfo(String title, String snippet, String url) {
        this.title = title;
        this.snippet = snippet;
        this.url = url;
    }

    /**
     * Returns the title of the page.
     * @return The title of the page.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns a snippet of text describing the page.
     * @return A snippet of text describing the page.
     */
    public String getSnippet() {
        return snippet;
    }

    /**
     * Returns the URL of the page.
     * @return The URL of the page.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Prints the title, snippet, and URL of the page to the console.
     */
    public void display() {
        System.out.println("Title: " + title);
        System.out.println("Snippet: " + snippet);
        System.out.println("URL: " + url);
        System.out.println();
    }
}
