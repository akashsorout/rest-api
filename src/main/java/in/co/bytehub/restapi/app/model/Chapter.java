package in.co.bytehub.restapi.app.model;

import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Embeddable
public class Chapter {


    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer chapterNum;
    private String name;

    public Chapter() {
    }

    public Integer getChapterNum() {
        return chapterNum;
    }

    public Chapter setChapterNum(Integer chapterNum) {
        this.chapterNum = chapterNum;
        return this;
    }

    public String getName() {
        return name;
    }

    public Chapter setName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Chapter{");
        sb.append("name='").append(name).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
