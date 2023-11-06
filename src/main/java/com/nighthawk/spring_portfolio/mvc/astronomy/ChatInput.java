// yuri
package com.nighthawk.spring_portfolio.mvc.astronomy;

public class ChatInput {
    private String content;

    // No-args constructor
    public ChatInput() {
    }

    // All-args constructor
    public ChatInput(String content) {
        this.content = content;
    }

    // Getter
    public String getContent() {
        return content;
    }

    // Setter
    public void setContent(String content) {
        this.content = content;
    }
}
