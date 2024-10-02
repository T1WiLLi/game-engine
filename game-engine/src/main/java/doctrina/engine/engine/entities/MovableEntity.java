package doctrina.engine.engine.entities;

import doctrina.engine.engine.controls.Direction;

public abstract class MovableEntity extends StaticEntity {

    protected int speed = 1;
    protected Direction direction = Direction.UP;

    public abstract void update();

    public void move() {
        x += direction.getVelocityX(speed);
        y += direction.getVelocityY(speed);
    }

    public void move(Direction direction) {
        this.direction = direction;
        move();
    }

    public void moveUp() {
        move(Direction.UP);
    }

    public void moveDown() {
        move(Direction.DOWN);
    }

    public void moveLeft() {
        move(Direction.LEFT);
    }

    public void moveRight() {
        move(Direction.RIGHT);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
}
