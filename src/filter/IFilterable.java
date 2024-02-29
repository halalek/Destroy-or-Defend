package filter;

import Game.Arena;
import Model.Object.Unit;
import filter.Filter;

import java.util.ArrayList;
import java.util.List;

public interface IFilterable {
 abstract ArrayList addFilter(Filter filter, Arena a, Unit unit)  ;

}