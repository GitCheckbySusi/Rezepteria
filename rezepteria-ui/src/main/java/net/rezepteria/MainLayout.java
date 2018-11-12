package net.rezepteria;

import com.vaadin.flow.component.dependency.StyleSheet;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.router.RouterLayout;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.theme.lumo.Lumo;
import net.rezepteria.about.AboutView;
import net.rezepteria.crud.SampleCrudView;
import net.rezepteria.inbox.InboxView;
import net.rezepteria.rezeptliste.RezeptlisteView;

/**
 * The layout of the pages e.g. About and Inventory.
 */
@StyleSheet("css/shared-styles.css")
@Theme(value = Lumo.class, variant = Lumo.DARK)
public class MainLayout extends FlexLayout implements RouterLayout {
    private Menu menu;

    public MainLayout() {
        setSizeFull();
        setClassName("main-layout");

        menu = new Menu();
        
        menu.addView(InboxView.class, InboxView.VIEW_NAME,
                VaadinIcon.EDIT.create());
        
        menu.addView(RezeptlisteView.class, RezeptlisteView.VIEW_NAME,
                VaadinIcon.BOOK.create());
        
        
        menu.addView(SampleCrudView.class, SampleCrudView.VIEW_NAME,
                VaadinIcon.EDIT.create());
        
        
        
        
        menu.addView(AboutView.class, AboutView.VIEW_NAME,
                VaadinIcon.INFO_CIRCLE.create());

        add(menu);
    }
}
