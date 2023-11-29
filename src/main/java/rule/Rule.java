package rule;

import cell.Cell;

public interface Rule {

    public boolean canApply(Cell c);

    public void apply(Cell c);
}
