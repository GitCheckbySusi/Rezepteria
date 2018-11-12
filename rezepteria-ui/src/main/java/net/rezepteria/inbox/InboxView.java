package net.rezepteria.inbox;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.Version;
import net.rezepteria.MainLayout;

@Route(value = "Inbox", layout = MainLayout.class)
@PageTitle("Inbox")
public class InboxView extends HorizontalLayout {

    public static final String VIEW_NAME = "Inbox";

    public InboxView() {
        add(VaadinIcon.HAMMER.create());
        add(new Span(" Die View "+VIEW_NAME+" ist noch nicht entwickelt "));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
    }
}
