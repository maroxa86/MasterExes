/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversores;

/**
 *
 * @author Xavi
 */
class URLBookmark {
    String fullURL;

    public URLBookmark(String fullURL) {
            this.fullURL = fullURL;
    }

    public String getFullURL() {
            return fullURL;
    }

    public void setFullURL(String fullURL) {
            this.fullURL = fullURL;
    }

    public String toString(){
            return fullURL;
    }
}
