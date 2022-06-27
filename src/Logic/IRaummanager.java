
package Logic;

import Domainmodell.Raum;

public interface IRaummanager {

  void addRaum(Raum raum);

  void removeRaum(int raumID);

  Raum[] getRaeume(int raumID);

  Raum createRaum(int sitzplaetze, String raumnummer);

}
