// Internal action code for project ia_submission

package mapping;

import java.util.List;

import jason.*;
import jason.asSemantics.*;
import jason.asSyntax.*;

public class update_resource_atx extends DefaultInternalAction {

    @Override
    public Object execute(TransitionSystem ts, Unifier un, Term[] args) throws Exception {
        // execute the internal action
        ts.getAg().getLogger().info("executing internal action 'mapping.update_resource_atx'");
        
        int x = (int)((NumberTerm)args[0]).solve();
        int y = (int)((NumberTerm)args[1]).solve();
        int q = (int)((NumberTerm)args[2]).solve();
        
        Pair loc = new Pair(x,y);
        Map.updateResource(loc,q);

        List<MapEntry> resources = Map.getResources();
        
        for (MapEntry r : resources) {
        	ts.getAg().getLogger().info(r.getContent()+" "+", loc ("+r.getLoc().getX()+","+r.getLoc().getY()+"), Qty:"+r.getQty());
        }
        // everything ok, so returns true
        return true;

    }
}
