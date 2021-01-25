package io.foojay.support.ioprovider;

import java.awt.BorderLayout;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JPanel;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.openide.windows.IOContainer;

@SuppressWarnings("guieffect")
public class IOContainerPanel extends JPanel implements IOContainer.Provider {
    
    public IOContainerPanel() {
        super(new BorderLayout());
    }

    @Override
    public void open() {
        //always open
    }

    @Override
    public void requestActive() {
        super.requestFocus();
    }

    @Override
    public void requestVisible() {
        super.requestFocus();
    }

    @Override
    public boolean isActivated() {
        return true;
    }

    @Override
    public void add(JComponent c, IOContainer.CallBacks callback) {
        super.add(c, BorderLayout.CENTER);
        //TODO: delegate callbacks?
        //TODO: assert only 1 child component?
    }

    @Override
    public void remove(JComponent c) {
        super.remove(c);
    }

    @Override
    public void select(JComponent c) {
        //nothing, because only 1 component is allowed.
        //TODO: assert?
    }

    @Override
    public @NonNull JComponent getSelected() {
        return getComponentCount() == 0 ? this /* correct ? */ : (JComponent) super.getComponent(0);
    }

    @Override
    public void setTitle(JComponent c, String title) {
        //nothing
    }

    @Override
    public void setToolTipText(JComponent c, String t) {
        //nothing
    }

    @Override
    public void setIcon(JComponent c, Icon i) {
        //nothing
    }

    @Override
    public void setToolbarActions(JComponent c, Action[] a) {
        //nothing
    }

    @Override
    public boolean isCloseable(JComponent c) {
        return false;
    }

}
