package net.rezepteria.rezeptliste;

import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.BeforeEvent;
import com.vaadin.flow.router.HasUrlParameter;
import com.vaadin.flow.router.OptionalParameter;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.RouteAlias;
import com.vaadin.flow.server.Version;
import net.rezepteria.MainLayout;

@Route(value = "Rezeptliste", layout = MainLayout.class)
@RouteAlias(value = "", layout = MainLayout.class)
@PageTitle("Rezeptliste")
public class RezeptlisteView extends HorizontalLayout   implements HasUrlParameter<String>{

    public static final String VIEW_NAME = "Rezeptliste";

    public RezeptlisteView() {
        add(VaadinIcon.HAMMER.create());
        add(new Span(" Die View "+VIEW_NAME+" ist noch nicht entwickelt "));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setAlignItems(Alignment.CENTER);
    }

    @Override
    public void setParameter(BeforeEvent event,
                             @OptionalParameter String parameter) {
        // viewLogic.enter(parameter);
    }
}
