public class Notes {
    private String diaryTitle;
    private String diaryEntries;
    private String localDate;

    public Notes(String diaryTitle, String diaryEntries, String localDate) {
        this.diaryTitle = diaryTitle;
        this.diaryEntries = diaryEntries;
        this.localDate = localDate;
    }

    public Notes(String diaryTitle) {
        this.diaryTitle = diaryTitle;
    }

    public String getDiaryTitle() {
        return diaryTitle;
    }

    public void setDiaryTitle(String diaryTitle) {
        this.diaryTitle = diaryTitle;
    }

    public String getDiaryEntries() {
        return diaryEntries;
    }

    public void setDiaryEntries(String diaryEntries) {
        this.diaryEntries = diaryEntries;
    }

    public String getLocalDate() {
        return localDate;
    }

    public void setLocalDate(String localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Notes{" +
                "diaryTitle='" + diaryTitle + '\'' +
                ", diaryEntries='" + diaryEntries + '\'' +
                ", localDate='" + localDate + '\'' +
                '}';
    }
}

