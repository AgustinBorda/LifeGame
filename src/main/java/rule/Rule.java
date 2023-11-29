package rule;

import cell.Cell;

public interface Rule {

    public boolean canApply(Cell c);

    public Cell apply(Cell c);
}
