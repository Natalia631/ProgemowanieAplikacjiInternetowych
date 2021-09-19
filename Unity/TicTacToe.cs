using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using UnityEngine.UI;

public class GameController : MonoBehaviour {

    public int whoTurns; // 0->O 1->X
    public int turnCount;
    public GameObject[] turnIcons;
    public Sprite[] playIcons;
    public Button[] tictactoeSpaces;

    void Start() {
        GameSetup();
    }

    void GameSetup() {
        whoTurns = 0;
        turnCount = 0;
        turnIcons[0].SetActive(true);
        turnIcons[1].SetActive(false);
        for(int i=0; i<tictactoeSpaces.Lenght; i++){
            tictactoeSpaces[i].iteractable=true;
            tictactoeSpaces[i].GetComponent<Image>().Sprite = null;
        }

    }

    void Update() {

    }
}