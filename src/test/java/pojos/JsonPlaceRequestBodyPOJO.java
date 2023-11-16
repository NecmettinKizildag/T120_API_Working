package pojos;

public class JsonPlaceRequestBodyPOJO {


    // 1 - tum variable lari private olarak olusturalim

    private String title;
    private String body;
    private int userId;
    private int id;

    // 2 - tum varible lar icin getter() an setter() method lari olusturalim


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    // 3 - tum parametreleri iceren bir constructor olusturalim


    public JsonPlaceRequestBodyPOJO(String title, String body, int userId, int id) {
        this.title = title;
        this.body = body;
        this.userId = userId;
        this.id = id;
    }

    // 4 - default constructor (parametresiz) olusturalim

    public JsonPlaceRequestBodyPOJO() {
    }


    // 5 - toString() method u olusturalim


    @Override
    public String toString() {
        return "JsonPlaceRequestBodyPOJO{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                ", userId=" + userId +
                ", id=" + id +
                '}';
    }
}
