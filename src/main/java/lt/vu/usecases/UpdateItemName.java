package lt.vu.usecases;

import lt.vu.services.ItemNameUpdateAsync;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@SessionScoped
@Named

public class UpdateItemName implements Serializable {
    private int itemId;

    @Inject
    private ItemNameUpdateAsync nameUpdater;

    private CompletableFuture<String> update1;

    private CompletableFuture<String> update2;

    @PostConstruct
    public void init() {
        Map<String, String> requestParameters =
                FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        itemId = Integer.parseInt(requestParameters.get("itemId"));
    }

    public String updateAsync(){
        update1 = CompletableFuture.supplyAsync(() -> nameUpdater.update(itemId,"ItemName_1", 2000, 0));
        update2 = CompletableFuture.supplyAsync(() -> nameUpdater.update(itemId,"ItemName_2", 0, 3000));
        return "itemDetails.xhtml?itemId=" + this.itemId + "&faces-redirect=true";
    }

    public boolean update1Running() {
        return this.update1 != null && !this.update1.isDone();
    }

    public boolean update2Running() {
        return this.update2 != null && !this.update2.isDone();
    }

    public String getUpdate1Status() throws ExecutionException, InterruptedException {
        if (update1 == null)
            return null;
        else if (update1Running())
            return "Update 1 is running";
        return "Update1 finished. Exit Status: " + update1.get();
    }

    public String getUpdate2Status() throws ExecutionException, InterruptedException {
        if (update2 == null)
            return null;
        else if (update2Running())
            return "Update 2 is running";
        return "Update2 finished. Exit Status: " + update2.get();
    }
}
