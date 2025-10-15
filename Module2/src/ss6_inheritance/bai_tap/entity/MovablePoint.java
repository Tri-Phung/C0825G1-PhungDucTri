package ss6_inheritance.bai_tap.entity;

public class MovablePoint extends Point {
    private float xSpeed = 0.0f;
    private float ySpeed = 0.0f;
    public MovablePoint() {}
    public MovablePoint(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public MovablePoint(float x, float y, float xSpeed, float ySpeed) {
        super(x, y);
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public float getXSpeed() {
        return xSpeed;
    }

    public void setXSpeed(float xSpeed) {
        this.xSpeed = xSpeed;
    }

    public float getYSpeed() {
        return ySpeed;
    }

    public void setYSpeed(float ySpeed) {
        this.ySpeed = ySpeed;
    }
    public void setSpeed(float xSpeed, float ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public float[] getSpeed() {
        return new float[]{super.getX(), super.getY(), xSpeed, ySpeed};
    }

    @Override
    public String toString() {
        return "MovablePoint{" +
                "x=" + super.getX() +
                ", y=" + super.getY() +
                ", speed= " + "(" + xSpeed + ", " + ySpeed +
                ")}";
    }
    public MovablePoint move() {
        float newX = super.getX() + xSpeed;
        float newY = super.getY() + ySpeed;
        super.setXY(newX, newY);
        return this;
    }
}
