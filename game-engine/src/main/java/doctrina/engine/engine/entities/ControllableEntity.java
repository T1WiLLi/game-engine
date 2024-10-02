package doctrina.engine.engine.entities;

import doctrina.engine.engine.controls.MovementController;

public abstract class ControllableEntity extends MovableEntity {
    private final MovementController controller;

    public ControllableEntity(MovementController controller) {
        this.controller = controller;
    }

    public void moveWithController() {
        if (controller.isMoving()) {
            move(controller.getDirection());
        }
    }
}
