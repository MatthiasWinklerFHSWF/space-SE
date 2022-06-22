
package Logic;

import Domainmodell.Raum;

public interface IRaummanager {

  void addRaum(String raumnummer, int sitzplaetze);

  void removeRaum(int raumID);

  Raum[] getRaeume(int raumID);
}
