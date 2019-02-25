package Z_Exam24Feb2019.heroRepository;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class HeroRepository {

    private static final Comparator<Hero> BY_STRENGTH_DESC =
            (a, b) -> Integer.compare(b.getItem().getStrength(), a.getItem().getStrength());

    private static final Comparator<Hero> BY_AGILITY_DESC =
            (a, b) -> Integer.compare(b.getItem().getAgility(), a.getItem().getAgility());

    private static final Comparator<Hero> BY_INTELLIGENCE_DESC =
            (a, b) -> Integer.compare(b.getItem().getIntelligence(), a.getItem().getIntelligence());

    private Map<String, Hero> data;

    public HeroRepository() {
        this.data = new LinkedHashMap<>();
    }

    public void add(Hero entity) {
        this.data.putIfAbsent(entity.getName(), entity);
    }

    public void remove(String name) {
        this.data.remove(name);
    }

    public Hero getHeroWithHighestStrength() {
        return this.getData(BY_STRENGTH_DESC);
    }

    public Hero getHeroWithHighestAgility() {
        return this.getData(BY_AGILITY_DESC);

    }

    public Hero getHeroWithHighestIntelligence() {
        return this.getData(BY_INTELLIGENCE_DESC);
    }

    private Hero getData(Comparator<Hero> comparator) {
        return this.data
                .values()
                .stream()
                .min(comparator)
                .orElse(null);
    }

    public int getCount() {
        return this.data.size();

    }

    @Override
    public String toString() {
        return this.data
                .values()
                .stream()
                .map(Hero::toString)
                .collect(Collectors.joining("\n"));
    }
}
