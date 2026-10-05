package fr.polytech.jeu;

public class GameManager {

    void GameManager() {
    }

    public enum State {
        START, PLAY, END;

        public enum Level {
            I, II, III, IV, V, VI, VII
        }

    }

    public void switchState(State state, State.Level level) {
        switch (state) {
            case START:
                state = State.PLAY;
                break;
            case PLAY:
                switch (level) {
                    case I:
                        level = State.Level.II;
                        break;
                    case II:
                        level = State.Level.III;
                        break;
                    case III:
                        level = State.Level.IV;
                        break;
                    case IV:
                        level = State.Level.V;
                        break;
                    case V:
                        level = State.Level.VI;
                        break;
                    case VI:
                        level = State.Level.VII;
                        break;
                    case VII:
                        state = State.END;
                        break;
                }
            default:
                break;
        }
    }

}
