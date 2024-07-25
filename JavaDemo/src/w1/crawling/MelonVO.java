package w1.crawling;

public class MelonVO implements java.io.Serializable {
    private int id;
    private String rank;
    private String title;
    private String singer;
    private String albumImage;

    public MelonVO(int id, String rank, String title, String singer, String albumImage) {
        this.id = id;
        this.rank = rank;
        this.title = title;
        this.singer = singer;
        this.albumImage = albumImage;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbumImage() {
        return albumImage;
    }

    public void setAlbumImage(String albumImage) {
        this.albumImage = albumImage;
    }

    @Override
    public String toString() {
        return "MelonVO{" +
                "id=" + id +
                ", rank='" + rank + '\'' +
                ", title='" + title + '\'' +
                ", singer='" + singer + '\'' +
                ", albumImage='" + albumImage + '\'' +
                '}';
    }
}
