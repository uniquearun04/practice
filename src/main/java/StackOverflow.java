import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by achaudhary on 7/17/18.
 */
public class StackOverflow {



    public List<TeamStanding> createStandingsTable(Match[] matches){
        List<TeamStanding> teamStandings = new ArrayList<TeamStanding>();

        return teamStandings;
    }

    public List<TeamStanding> mergeTeamStandingList(List<TeamStanding> teamStandingList) {
        final Map<Integer, TeamStanding> idTeamVsTeamStandingMap = new HashMap<Integer, TeamStanding>();
        teamStandingList.forEach(teamStanding -> {
            if(idTeamVsTeamStandingMap.containsKey(teamStanding.getIdTeam())) {
                TeamStanding teamStanding1 = idTeamVsTeamStandingMap.get(teamStanding.getIdTeam());
                teamStanding1.setTeamDraws(teamStanding1.getTeamDraws() + teamStanding.getTeamDraws());
                //so on
            } else {
                idTeamVsTeamStandingMap.put(teamStanding.getIdTeam(), teamStanding);
            }
        });

        return new ArrayList<>(idTeamVsTeamStandingMap.values());
    }



    private static class Match {

    }

    @lombok.Getter
    @Setter
    private static class TeamStanding {
        private Integer idTeam;
        private Integer teamPoints;
        private Integer teamPlayed;
        private Integer teamWins;
        private Integer teamDraws;
        private Integer teamLoses;
        private Integer teamGoalsFavor;
        private Integer teamGoalsAgainst;
        private Integer teamGoalDif;
    }

}
