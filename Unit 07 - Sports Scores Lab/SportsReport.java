/**
 * The SportsReport class reads the string and extracts the
 * needed information from the string to pass to the
 * SportsTester class.
 * @author Ethan Chou
 * Collaborators: None
 * Teacher Name: Bailey
 * Period: 1
 * Due Date: 12-2-2019
 */
public class SportsReport
{
	/** Names of the winning and losing teams */
	private String winner;
	private String loser;

	/** the winning and losing scores */
	private int winningScore;
	private int losingScore;

	/** delimiter phrases */
	private	static final String beat = " beat ";
	private	static final String howMuch = " by a score of ";
	private	static final String compareScore = " to ";

	/** Constructs a SportsReport using the information in score
	 *  @param score contains winner, loser, and scores in the format:
	 *  <winner> beat <loser> by a score of <winning score> to <losing score>
	 */
	public SportsReport(String score)
	{
		extractInformation(score);
	}

	/** Changes the sports scoring information
	 *  @param score contains winner, loser, and scores in the format:
	 *  <winner> beat <loser> by a score of <winning score> to <losing score>
	 */
	public void changeScoringInfo(String score)
	{
		extractInformation(score);
	}

	/** Gets the name of the winner
	 *  @return the name of the winner
	 */
	public String getWinner()
	{
		return winner;
	}

	/** Gets the name of the loser
	 *  @return the name of the loser
	 */
	public String getLoser()
	{
		return loser;
	}

	/** Gets the winning score
	 *  @return the winning score
	 */
	public int getWinningScore()
	{
		return winningScore;
	}

	/** Gets the losing score
	 *  @return the losing score
	 */
	public int getLosingScore()
	{
		return losingScore;
	}

	// write getScoreDifference method HERE!!
	public int getScoreDifference()
	{
		int total = 0;
		total = getWinningScore() - getLosingScore();
		return total;
	}

	@Override
	public String toString()
	{

		String moreStr = "";
		for (int count = 0; count <=7; count++)
		{
			moreStr = String.format("%-25s %4d,  %-25s %4d",
			winner, winningScore, loser, losingScore);
		}

		return moreStr;
	}

	// write PRIVATE extractInformation method HERE!!
	/** Extracts the information from the given string
	 *  @param the string
	 */
	private void extractInformation(String score)
	{
		int winName = score.indexOf(beat);
		winner  = score.substring(0, winName);
		int loseName = score.indexOf(beat) + 6;
		int scoreDif = score.indexOf(howMuch);
		loser = score.substring(loseName, scoreDif);
		int winScore = score.indexOf(howMuch) + 15;
		int winScore2 = score.indexOf(compareScore);
		String winnerScore = score.substring(winScore, winScore2);
		winningScore = Integer.parseInt(winnerScore);

		int loseScore = score.indexOf(compareScore) + 4;
		int loseScore4 = score.length();
		String loseScore3 = score.substring(loseScore, loseScore4);
		int loseScore2 = Integer.parseInt(loseScore3);
		String loserScore = score.substring(winScore, winScore2);
		winningScore = Integer.parseInt(winnerScore);
		losingScore = loseScore2;

	}

}