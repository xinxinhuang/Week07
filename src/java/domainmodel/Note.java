/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domainmodel;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author 727153
 */
public class Note {
    private int noteId;
    private Date dateCreated;
    private String contents;

    public Note() {
    }

    public Note(int noteId, String contents) {
        this.noteId = noteId;
        this.dateCreated = new Date();
        this.contents = contents;
    }
    
    public Note(int noteId, Date dateCreated, String contents) {
        this.noteId = noteId;
        this.dateCreated = dateCreated;
        this.contents = contents;
    }

    public String getContents() {
        return contents;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public int getNoteId() {
        return noteId;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public void setNoteId(int noteId) {
        this.noteId = noteId;
    }
    
    
}
