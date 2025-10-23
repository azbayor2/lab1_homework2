package step1;

class Rectangle {
    private double width;
    private double height;

    // 생성자
    Rectangle(double w, double h) {
        this.width = w;
        this.height = h;
    }

    Rectangle(){
        this.width = 0;
        this.height = 0;
    }

    @Override
    public String toString(){
        double area = width*height;

        return ""+ area;
    }

    // 넓이 계산
    double area() {
        return width * height;
    }

    // Getter/Setter
    public double getWidth() { return width; }
    public void setWidth(double w) { width = w; }
    public double getHeight() { return height; }
    public void setHeight(double h) { height = h; }

}

class Main {
    public static void main(String[] args) {
        Rectangle r = new Rectangle(5, 10);
        //System.out.println("넓이: " + r.area());
        System.out.println(r);

        Rectangle rr = new Rectangle();
        rr.setHeight(5);
        rr.setWidth(10);
        System.out.println(rr);

        return;
    }
}
