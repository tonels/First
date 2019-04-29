/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aust.two.value;

import lombok.Data;

/**
 *
 * @author Thorben
 */
@Data
public class BookValue {

    private Long id;
    private String title;
    private Long version;
    private String authorName;

    public BookValue(Long id, String title, Long version, String authorName) {
        this.id = id;
        this.title = title;
        this.version = version;
        this.authorName = authorName;
    }

}
