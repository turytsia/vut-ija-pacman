package game.view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

import game.common.CommonField;
import game.common.CommonMazeObject;
import game.common.Observable;
import game.objects.FinishObject;
import game.objects.GhostObject;
import game.objects.KeyObject;
import game.objects.PointObject;

import java.awt.Graphics;

public class FieldView extends JPanel implements Observable.Observer {
    private final List<ComponentView> objects = new ArrayList<>();
    private CommonField field;

    public FieldView(CommonField field) {
        this.field = field;
        field.addObserver(this);
        setOpaque(false);
        updateView();
    }

    private void updateView() {
        if (field.isEmpty()) {
            objects.clear();
        } else {
            CommonMazeObject obj = field.get();
            if (obj.isPacman()) {
                this.objects.add(new PacmanView(this, obj));
            } else if (obj instanceof GhostObject) {
                this.objects.add(new GhostView(this, obj));
            } else if (obj instanceof KeyObject) {
                this.objects.add(new KeyView(this, obj));
            } else if (obj instanceof FinishObject) {
                this.objects.add(new FinishView(this, obj));
            } else if (obj instanceof PointObject) {
                this.objects.add(new PointView(this, obj));
            } else {
                System.out.println("Something is wrong...");
            }
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        this.objects.forEach((v) -> {
            v.paintComponent(g);
        });
    }

    @Override
    public void update(Observable f) {
        updateView();
    }
    
}
