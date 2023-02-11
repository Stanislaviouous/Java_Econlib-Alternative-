package sample;
import java.lang.Character. *;

import java.util.Scanner;

public class Econlib {
    ///ГЛОБАЛЬНЫЕ ДАННЫЕ///
    public float answer;
    public float PI = (float) 3.1415;

    ///КАТАЛОГ ФУНКЦИЙ///;
    /*void InformationAboutLibrary() {
        tem.out.printlnSys("Данный класс был создан Юрием Дьяченко и Станиславом Дьяченко для расчёта экономических формул и построения соответствующих графиков.");
        System.out.println("Каталог:");
        System.out.println("Эластичность спроса по цене - E_pd.");
        System.out.println("Эластичность спроса по доходу - E_yd.");
        System.out.println("Эластичность предложения по цене - E_pd.");
        System.out.println("Доход - Y_k");
        System.out.println("Цена - P_k");
        System.out.println("Объём - Q_k");
        System.out.println("Индекс Леренера - LernerIndex_1");
        System.out.println("Индекс Леренера  - LernerIndex_2");
        System.out.println("Индекс Леренера - LernerIndex_3");
        System.out.println("Индекс Леренера - LernerIndex_4");
        System.out.println("Общие издержки - TC");
        System.out.println("Средние издержки - AC_1");
        System.out.println("Средние издержки - AC_2");
        System.out.println("Средние постоянные издержки - AFC");
        System.out.println("Средние постоянные издержки - AVC");
        System.out.println("   Будущая стоимость вложений при начислении простого процента - FV_simple");
        System.out.println("Будущая стоимость вложений при начислении сложного процента - FV_complex");
        System.out.println("Текущая стоимость купонной облигации - PV_coupon");
        System.out.println("Текущая стоимость дисконтной облигации - PV_discount");
        System.out.println("Чистая цена облигации - CPO");
        System.out.println("Дюрация Маколея при выплате купона один раз в год - D_one");
        System.out.println("Дюрация Маколея при выплате купона несколько раз в год - D_more");
        System.out.println("Дюрация Маколея при выплате купона один раз в год и сроки жизни облигации много лет - D_one_wut");
    }*/

    ///ФУНКЦИИ - ПОМОЩНИКИ (КОСТЫЛИ)///
//    void support_1() {
//	/*Данная функция из разряда помощников основному коду,
//	Созданна как костыль. */
//        System.out.println("Введите необходимые данные");
//    }

    float sum(float a[], int n) {
	/*Фунция для расчёта стандартной алгебраической суммы - Σ, где
	a[] - слагаемые.*/
        float sum = 0;
        for (int i = 0; i < n; ++i) {
            sum += a[i];
        }
        return sum;
    }

    public String CinToString() {
        Scanner i = new Scanner(System.in);
        String r = i.nextLine();
        return r;
    }

    public float CinToFloat(Scanner in) {
        float rqst = in.nextFloat();
        return rqst;
    }

    ///ФУНКЦИИ ЭЛАСТИЧНОСТИ СПРОСА///
    double E_pd(float P1, float Q1, float P2, float Q2) {
	/*Функция для подсчёта эластичности спроса по цене,где
	P1 - первоначальная цена в выбранном интервале,
	P2 - конечная цена в выбранном интервале,
	P - прирост цены,
	Q1 - первоначальный объём спроса в выбранном интервале,
	Q2 - конечный объём спроса в выбранном интервале,
	Q - прирост объёма спроса.*/
        float P = P2 - P1;
        float Q = Q2 - Q1;
        answer = Math.abs(((P1 + P2) / (Q1 + Q2)) * (Q / P));
        return answer;
    }

    public double E_yd(float Y1, float Q1, float Y2, float Q2) {
	/*Функция для подсчёта эластичности спроса по доходам,где
	Y1 - первоначальный доход в выбранном интервале,
	Y2 - конечный доход в выбранном интервале,
	Y - прирост доходов,
	Q1 - первоначальный объём спроса в выбранном интервале,
	Q2 - конечный объём спроса в выбранном интервале,
	Q - прирост объёма спроса.*/
        float Y = Y2 - Y1;
        float Q = Q2 - Q1;
        answer = (((Y1 + Y2) / (Q1 + Q2)) * (Q / Y));
        return answer;
    }

    ///ФУНКЦИЯ ЭЛАСТИЧНОСТИ ПРЕДЛОЖЕНИЯ///
    public double E_ps(float P1, float Q1, float P2, float Q2) {
	/*Функция для подсчёта эластичности предложения по цене,где
	P1 - первоначальная цена в выбранном интервале,
	P2 - конечная цена в выбранном интервале,
	P - прирост цены,
	Q1 - первоначальный объём предложения в выбранном интервале,
	Q2 - конечный объём предложения в выбранном интервале,
	Q - прирост объёма предложения.*/
        float P = P2 - P1;
        float Q = Q2 - Q1;
        answer = Math.abs((((P1 + P2) / (Q1 + Q2)) * (Q / P)));
        return answer;
    }

    ////ФУНКЦИИ ДОХОДА, ЦЕНЫ И КОЛИЧЕСТВА ПРОДАННОЙ ПРОДУКЦИИ. Ключ формулы - k///
//k___Y=P*Q___k//
    public double Y_k(float Pk, float Qk) {
	/*Функция для подсчёта дохода,где
	Pk - цена единицы продукта,
	Qk - кол-во проданной продукции.*/
        answer = Pk * Qk;
        return answer;
    }

    public double P_k(float Yk, float Qk) {
	/*Функция для подсчёта цены исходя из дохода и проданной продукции,где
	Yk - доход,
	Qk - количество проданной продукции.*/
        answer = Yk / Qk;
        return answer;
    }

    public double Q_k(float Yk, float Pk) {
	/*Функция для подсчёта количества проданного товара исходя из цены и дохода,где
	Pk - цена единицы продукта,
	Yk - доход.*/
        answer = Yk / Pk;
        return answer;
    }

    ///ФУНКЦИИ РАСЧЁТА ИНДЕКСА ЛЕРНЕРА///
    public double LernerIndex_1(float Epd) {
	/*Расчёт индекса Лернера, где
	Epd - эластичность спроса по цене*/
        answer = 1 / (-Epd);
        return answer;
    }

    public double LernerIndex_2(float P, float MC) {
	/*Расчёт индекса Лернера, где
	P - цена,
	MC - предельные издержки*/
        answer = (P - MC) / P;
        return answer;
    }

    public double LernerIndex_3(float P, float ATC) {
	/*Расчёт индекса Лернера, где
	P - цена,
	ATC - средние общие издержки*/
        answer = (P - ATC) / ATC;
        return answer;
    }

    public double LernerIndex_4(float P, float T_C) {
	/*Расчёт индекса Лернера, где
	P - цена,
	T_C - общие издержки*/
        answer = P / T_C;
        return answer;
    }

    ///ФУНКЦИИ ИЗДЕРЖЕК///
    public double TC(float FC, float VC) {
	/*Расчёт общих издержек, где
	FC - постоянные издержки,
	VC - переменные издержки*/
        answer = FC + VC;
        return answer;
    }

    public double AC_1(float T_C, float Q) {
	/*Расчёт средних постоянных издержек, где
	T_C - общие издержки,
	Q - обЪём выпуска продукции*/
        answer = T_C / Q;
        return answer;
    }

    public double AFC(float FC, float Q) {
	/*Расчёт средних постоянных издержек, где
	FC - постоянные издержки,
	Q - обЪём выпуска продукции*/
        answer = FC / Q;
        return answer;
    }

    public double AVC(float VC, float Q) {
	/*Расчёт средних переменных издержек, где
	VC -  переменные издержки,
	Q - обЪём выпуска продукции.*/
        answer = VC / Q;
        return answer;
    }

    public double AC_2(float A_FC, float A_VC) {
	/*Расчёт средних постоянных издержек, где
	A_FC - средние постоянные издержки,
	A_VC - средние переменные издержки.*/
        answer = A_FC + A_VC;
        return answer;
    }

    ///ФУНКЦИЯ ИНДЕКСА ДЖИНИ///
    public double GiniIndex(int n, float y[]) {
	/*Расчёта Индекса Джини, где
	n - количество слоёв населения с неравномерными доходами,
	y[] - массив процентных долей доходов каждого из слоёв.*/
        float[] ykam = new float[n];
        ykam[0] = y[0];
        for (int i = 1; i < n; i++) {
            ykam[i] = ykam[i - 1] + y[i];
        }
        float x = (float) (1 / n);
        answer = Math.abs(1 - 2 * x * sum(ykam, n) + x);
        return answer;
    }

    ///ФУНКЦИИ ПОЛЕЗНОСТИ///
    public double MU_A(float TU1, float Q1, float TU2, float Q2) {
	/*Расчёт предельной полезности, где
	TU1 - начальная общая полезность товара А
	Q1 - начальное количество товара А
	TU2 - конечная общая полезность товара А
	Q2 - конечное количество товара А*/
        answer = (TU1 - TU2) / (Q1 - Q2);
        return answer;
    }

    ///ФУНКЦИИ ПРОДУКТА ФИРМЫ///
    public double AP_L(float Q, float L) {
	/*Средняя производительность труда, где
	Q - объём произведённой продукции
	L - объём затраченной рабочей силы(объём труда).*/
        answer = Q / L;
        return answer;
    }

    public double AP_K(float Q, float K) {
	/*Величина средней капиталоотдачи, где
	Q - объём произведённой продукции
	K - количество капитала.*/
        answer = Q / K;
        return answer;
    }

    public double MP_L(float Q1, float L1, float Q2, float L2) {
	/*Расчёт предельного продукта труда, где
	Q1 - начальное количество товара
	L1 - начальное количество труда
	Q2 - конечное количество товара
	L2 - конечное количество труда.*/
        answer = (Q1 - Q2) / (L1 - L2);
        return answer;
    }

    public double MP_K(float Q1, float K1, float Q2, float K2) {
	/*Расчёт предельного продукта капитала, где
	Q1 - начальное количество товара
	K1 - начальное количество капитала
	Q2 - конечное количество товара
	K2 - конечное количество капитала.*/
        answer = (Q1 - Q2) / (K1 - K2);
        return answer;
    }

    ///ФУНКЦИИ СТОИМОСТИ ВЛОЖЕНИЙ///
    public double FV_simple(float PV, float r, float n) {
	/*Расчет будущей стоимости вложений при начислении простого процента при вкладе на 1 год или более, где
	PV – текущая стоимость вложения
	r- ставка процента под который размещаются средства в расчете на 1 год, выраженный в долях еденицы
	n – количество начисления процентов под ставку r.*/
        answer = PV * (1 + r * n);
        return answer;
    }

    public double FV_complex(float PV, float r, float n) {
	/*Расчет будущей стоимости вложений при начислении сложного процента при вкладе на 1 год или более, где
	PV – текущая стоимость вложения
	r- ставка процента под который размещаются средства в расчете на 1 год, выраженный в долях еденицы
	n – количество начисления процентов под ставку r.*/
        answer = (float) (PV * Math.pow(1 + r, n));
        return answer;
    }

    ///ФУНКЦИИ ЦЕНЫ ОБЛИГАЦИИ И ЕЕ ПАРАМЕТРОВ///
    public double PV_coupon(float N, float r, float u, float n) {
	/*Расчет текущей стоимости купонной облигации, где
	N – номинал облигации
	r- ставка без риска, выраженный в долях единицы
	u – размер выплачиваемого купона
	n – кол-во лет жизни облигации.*/
        float PV = 0, i = 1;
        while (i <= n) {
            PV = (float) (PV + (u / Math.pow(1 + r, i)));
            i++;
        }
        answer = (float) (PV + (N / Math.pow(1 + r, i)));
        return answer;
    }

    public double PV_discount(float N, float r, float n) {
	/*Расчет текущей стоимости дисконтной облигации, где
	N – номинал облигации
	r- ставка без риска, выраженный в долях единицы
	n – кол-во лет жизни облигации.*/
        answer = (float) (N / Math.pow(1 + r, n));
        return answer;
    }

    public double CPO(float DPO, float N, float r, float DS, float DE, float n) {
	/*Расчет чистой цены облигации, где
	DPO – грязная цена облигации
	N – номинал облигации;
	r- ставка без риска, выраженный в долях еденицы;
	DS – день начала купонного периода
	DE – день окончания или дня расчета НКД
	n – кол-во лет жизни облигации.*/
        answer = (float) (DPO - (N * r * (DS - DE) / Math.pow(1 + r, n)));
        return answer;
    }

    public double D_one(float N, float r, float C, float n, float P) {
	/*Расчет дюрации Маколея при выплате купона один раз в год
	N – номинал облигации;
	r - ставка без риска, выраженная в долях единицы
	С – размер выплачиваемого купона
	n – кол-во лет жизни облигации
	P – текущая стоимость облигации
	D – дюрация Маколея.*/
        float D = 0, i = 1;
        while (i <= n) {
            D = (float) (D + (i * C / Math.pow(1 + r, i)));
            i++;
        }
        answer = (float) ((D + n * (C + N) / Math.pow(1 + r, n)) / P);
        return answer;
    }

    public double D_more(float N, float r, float C, float n, float P, float m) {
	/*Расчет дюрации Маколея при выплате купона несколько раз в год
	N – номинал облигации;
	r - ставка без риска, выраженная в долях единицы
	С – размер выплачиваемого купона
	n – кол-во лет жизни облигации
	P – текущая стоимость облигации
	D – дюрация Маколея
	m – кол-во выплат купона в году.*/
        answer = (float) ((C / P) * (n * N / (P * Math.pow(r + 1 / m, m * n))) * ((Math.pow(1 + r / m, m * n + 1) - n * r - (1 + r / m)) / (r * r * Math.pow(1 + r / m, m * n))));
        return answer;
    }

    public double D_one_wut(float N, float r, float C, float n, float P) {
	/*Расчет дюрации Маколея при выплате купона один раз в год и сроки жизни облигации много лет
	N – номинал облигации;
	r - ставка без риска, выраженная в долях единицы
	С – размер выплачиваемого купона
	n – кол-во лет жизни облигации
	P – текущая стоимость облигации
	D – дюрация Маколея.*/
        answer = (float) ((C / P) * (n * N / (P * Math.pow(1 + r, n))) * ((Math.pow(1 + r, n + 1) - n * r - (1 + r)) / (r * r * Math.pow(1 + r, n))));
        return answer;
    }

    public double GDP_1(float C, float I, float G, float X) {
	/*Расчет ВВП на душу населения, где
	С – траты потребителей
	I – инвестиции
	G – гос. затраты
	X – показатель чистого экспорта (от общей стоимости вывозимых отнимаем сумму ввозимых).*/
        answer = C + I + G + X;
        return answer;
    }

    public double GDP_2(float VA, float TPI, float SIM) {
	/*Расчет ВВП на душу населения, где
	VA - добавленная стоимость
	TPI – налог на производство и импорт
	SIM – субсидии на импорт и изготовление.*/
        answer = VA + TPI - SIM;
        return answer;
    }

    public double GDP_3(float Sal, float pr, float CP, float IT, float A, float fc) { /* Need check*/
	/*Расчет ВВП за год, где
	Sal – это средства, затраченные на выплаты сотрудникам
	pr - стоимость аренды
	CP – выручка от процентов по банковским вкладам
	IT – косвенные налоги
	A – амортизация
	fc – зарубежный чистый факторный доход.*/
        answer = Sal + pr + CP + IT + A - fc;
        return answer;
    }

    ///ФУНКЦИЯ ДЛЯ РАБОТЫ СО СТРОКАМИ///
    public float Answer(String name) {
        Controller r = new Controller();

        Scanner in = new Scanner(System.in);
        if (name.equals("LernerIndex(Epd)")) {
            return (float) (LernerIndex_1((float) E_pd(r.A[0], r.A[1], r.A[2], r.A[3])));
        }

        if (name.equals("E_pd")) {
            return (float) E_pd(r.A[0], r.A[1], r.A[2], r.A[3]);
        }

        if (name.equals("E_yd")) {
            return (float) E_yd(r.A[0], r.A[1], r.A[2], r.A[3]);
        }

        if (name.equals("E_ps")) {
            return (float) E_ps(r.A[0], r.A[1], r.A[2], r.A[3]);
        }

        if (name.equals("LernerIndex_1")) {
            return (float) LernerIndex_1(r.A[0]);
        }

        if (name.equals("LernerIndex_2")) {
            return (float) LernerIndex_2(r.A[0], r.A[1]);
        }

        if (name.equals("LernerIndex_3")) {
            return (float) LernerIndex_3(r.A[0], r.A[1]);
        }

        if (name.equals("LernerIndex_4")) {
            return (float) LernerIndex_4(r.A[0], r.A[1]);
        }

        if (name.equals("TC")) {
            return (float) TC(r.A[0], r.A[1]);
        }

        if (name.equals("AC_1")) {
            return (float) AC_1(r.A[0], r.A[1]);
        }

        if (name.equals("AC_2")) {
            return (float) AC_2(r.A[0], r.A[1]);
        }

        if (name.equals("AFC")) {
            return (float) AFC(r.A[0], r.A[1]);
        }

        if (name.equals("AVC")) {
            return (float) AVC(r.A[0], r.A[1]);
        }

        if (name.equals("GiniIndex")) {
            int n = (int) r.A[0];
            float[] t = new float[n];
            for (int i = 0; i < n; i++) {
                t[i] = r.A[i+1];
            }
            return (float) GiniIndex(n, t);
        }

        if (name.equals("FV_simple")) {
            return (float) FV_simple(r.A[0], r.A[1], r.A[2]);
        }

        if (name.equals("FV_complex")) {
            return (float) FV_complex(r.A[0], r.A[1], r.A[2]);
        }

        if (name.equals("PV_coupon")) {
            return (float) PV_coupon(r.A[0], r.A[1], r.A[2], r.A[3]);
        }

        if (name.equals("PV_discount")) {
            return (float) PV_discount(r.A[0], r.A[1], r.A[2]);
        }

        if (name.equals("CPO")) {
            return (float) CPO(r.A[0], r.A[1], r.A[2], r.A[3], r.A[4], r.A[5]);
        }

        if (name.equals("D_one")) {
            return (float) D_one(r.A[0], r.A[1], r.A[2], r.A[3], r.A[4]);
        }

        if (name.equals("D_more")) {
            return (float) D_more(r.A[0], r.A[1], r.A[2], r.A[3], r.A[4], r.A[5]);
        }

        if (name.equals("D_one_wut")) {
            return (float) D_one_wut(r.A[0], r.A[1], r.A[2], r.A[3], r.A[4]);
        }

        if (name.equals("GDP_1")) {
            return (float) GDP_1(r.A[0], r.A[1], r.A[2], r.A[3]);
        }

        if (name.equals("GDP_2")) {
            return (float) GDP_2(r.A[0], r.A[1], r.A[2]);
        }

        if (name.equals("GDP_3")) {
            return (float) GDP_3(r.A[0], r.A[1], r.A[2], r.A[3], r.A[4], r.A[5]);
        }

        if (name.equals("Y_k")) {
            return (float) (Y_k(r.A[0], r.A[1]));
        }

        if (name.equals("P_k")) {
            return (float) (P_k(r.A[0], r.A[1]));
        }

        if (name.equals("Q_k")) {
            return (float) (Q_k(r.A[0], r.A[1]));
        }

        if (name.equals("MU_A")) {
            return (float) (MU_A(r.A[0], r.A[1], r.A[2], r.A[3]));
        }

        if (name.equals("AP_L")) {
            return (float) (AP_L(r.A[0], r.A[1]));
        }

        if (name.equals("AP_K")) {
            return (float) (AP_K(r.A[0], r.A[1]));
        }

        if (name.equals("MP_L")) {
            return (float) (MP_L(r.A[0], r.A[1], r.A[2], r.A[3]));
        }

        if (name.equals("MP_K")) {
            return (float) (MP_K(r.A[0], r.A[1], r.A[2], r.A[3]));
        } else {
            return (PI);
        }
    }

}
