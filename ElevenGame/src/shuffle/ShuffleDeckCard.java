package shuffle;

import elevengame.Deck;
import java.util.Collections;
import elevengame.ShuffleInterface;
import java.util.List;

/**
 *
 * @author Tomáš Malčík
 */
public class ShuffleDeckCard implements ShuffleInterface {

    @Override
    public void Suffle(ShuffleInterface o) {
        Collections.shuffle((List<?>) o);
    }
    
}