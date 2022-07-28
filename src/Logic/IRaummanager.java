
package Logic;

import Domainmodell.Raum;

public interface IRaummanager {

  void addRaum(Raum raum);

  void removeRaum(String raumnummer);

  Raum[] getRaum();

  Raum createRaum(int sitzplaetze, String raumnummer);

  String showRaumuebersicht();

}
